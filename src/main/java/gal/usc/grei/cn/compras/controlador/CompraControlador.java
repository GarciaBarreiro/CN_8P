package gal.usc.grei.cn.compras.controlador;

import gal.usc.grei.cn.compras.fachada.CompraFachada;
import gal.usc.grei.cn.compras.modelo.Compra;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/compras")
public class CompraControlador {
    // Referencia a la clase PrecioFachada
    private final CompraFachada compras;
    /**
     * Constructor de la clase
     * @param compras Instancia de la clase PrecioFachada
     */
    @Autowired
    public CompraControlador(CompraFachada compras) {
        this.compras = compras;
    }
    /**
     * Método: POST
     * Url para llegar: /compras
     * Objetivo: insertar la compra que se facilita como parámetro.
     *
     * @param compra los datos de la compra a insertar
     * @return Si la inserción se ha podido hacer, la nueva compra y la url para acceder a ella.
     */
    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Object> create(@Valid @RequestBody Compra compra) {
        try {
            //Tratamos de crear la compra:
            Optional<Compra> inserted = compras.create(compra);
            //Si se crea correctamente, devolvemos la información de la compra creada.
            return ResponseEntity.created(URI.create(
                            ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString() +
                                    "/compras/" + inserted.get().getId()))
                    .body(inserted.get());
        } catch (Exception e) { // changed from InstantiationException to Exception (because before: Exception 'java.lang.InstantiationException' is never thrown in the corresponding try block)
            //Si se captura la excepción de instanciación inválida, se devuelve una bad request.
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}