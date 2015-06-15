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

import org.hibernate.validator.Pattern;
import org.hibernate.validator.Size;
import org.jboss.seam.annotations.Name;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "USUARIO")
@SequenceGenerator(name = "SEQ_ID_USUARIO", sequenceName = "SEQ_ID_USUARIO", allocationSize = 1, initialValue = 1)
@Name("usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "SEQ_ID_USUARIO")
	@Column(name = "USUARIO_ID")
	private Long id;

	@NotNull
	@Column(name = "NOME", length = 50)
	@Size(min = 10, max = 50, message="O tamanho do nome deve ser entre {min} e {max} caracteres.")
	private String nome;

	@NotNull
	@Column(name = "EMAIL", length = 100)
	@Size(min = 20, max = 100, message="O tamanho do e-mail deve ser entre {min} e {max} caracteres.")
	@Pattern(regex = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[a-zA-Z]{2,4}$", message = "Email errado")
	private String email;

	@NotNull
	@Column(name = "LOGIN", length = 20)
	@Size(min = 5, max = 20, message="O tamanho do login deve ser entre {min} e {max} caracteres.")
	private String login;

	@NotNull
	@Column(name = "SENHA", length = 100)
	@Size(min = 5, max = 15, message="O tamanho da senha deve ser entre {min} e {max} caracteres.")
	private String senha;
	
	@Size(min = 5, max = 15, message="O tamanho da confirmação da senha deve ser entre {min} e {max} caracteres.")
	private String confSenha;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(name = "USUARIO_CONTATO", joinColumns = @JoinColumn(name = "USUARIO_CONTATO"), inverseJoinColumns = @JoinColumn(name = "CONTATO_ID"))
	private List<Contato> contatos = new ArrayList<Contato>();

	public Usuario() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfSenha() {
		return confSenha;
	}

	public void setConfSenha(String confSenha) {
		this.confSenha = confSenha;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public void addContato(Contato contato) {
		this.contatos.add(contato);
	}

	public void removeContato(Contato contato) {
		this.contatos.remove(contato);
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

		Usuario other = (Usuario) obj;

		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		return true;
	}

}
