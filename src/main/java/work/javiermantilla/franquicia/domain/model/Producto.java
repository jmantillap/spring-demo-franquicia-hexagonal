package work.javiermantilla.franquicia.domain.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto implements Serializable {

	private static final long serialVersionUID = 733209426202178370L;

	private Integer id;	
	private Sucursal sucursal;
	private String nombre;
	private Integer stock;
	public Producto(String nombre, Integer stock) {
		super();
		this.nombre = nombre;
		this.stock = stock;
	}
	
	
	
}
