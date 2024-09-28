package work.javiermantilla.franquicia.domain.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sucursal implements Serializable {

	private static final long serialVersionUID = -2166180173676134498L;
	private Integer id;
	private Franquicia franquicia;	
	private String nombre;
	public Sucursal(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	
}
