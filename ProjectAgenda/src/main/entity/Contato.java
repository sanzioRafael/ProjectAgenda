package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.jboss.seam.annotations.Name;

@Entity
@Table(name = "CONTATO")
@SequenceGenerator(name = "SEQ_ID_CONTATO", sequenceName = "SEQ_ID_CONTATO", allocationSize = 1, initialValue = 1)
@Name("contato")
public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "SEQ_ID_CONTATO")
	@Column(name = "CONTATO_ID")
	private Long id;

	@Column(name = "NOME_CONTATO", length = 100)
	private String nomeContato;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(name = "CONTATO_NUMERO", joinColumns = @JoinColumn(name = "CONTATO_ID"), inverseJoinColumns = @JoinColumn(name = "NUMERO_ID"))
	private List<Numero> numeros = new ArrayList<Numero>();

	public Contato() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	public List<Numero> getNumeros() {
		return numeros;
	}

	public void setNumeros(List<Numero> numeros) {
		this.numeros = numeros;
	}

	public void addNumero(Numero numero) {
		this.numeros.add(numero);
	}

	public void removeNumero(Numero numero) {
		this.numeros.remove(numero);
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

		Contato other = (Contato) obj;

		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		return true;
	}

}
