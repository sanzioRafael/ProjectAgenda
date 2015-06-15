package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.jboss.seam.annotations.Name;

import util.TipoContato;

@Entity
@Table(name = "NUMERO")
@SequenceGenerator(name = "SEQ_ID_NUMERO", sequenceName = "SEQ_ID_NUMERO", allocationSize = 1, initialValue = 1)
@Name("numero")
public class Numero implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "SEQ_ID_NUMERO")
	@Column(name = "NUMERO_ID")
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_CONTATO")
	private TipoContato tipoContato;

	@Column(name = "NUMERO", length = 50)
	private String numero;

	public Numero() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoContato getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(TipoContato tipoContato) {
		this.tipoContato = tipoContato;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((id == null) ? 0 : id.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Numero other = (Numero) obj;

		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		return true;
	}

}
