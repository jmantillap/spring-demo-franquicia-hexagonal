package work.javiermantilla.franquicia.domain.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Franquicia implements Serializable {

	private static final long serialVersionUID = 1504389609407931486L;
    private Integer id;
    private String nombre;    
    private Boolean estado;
    
}
