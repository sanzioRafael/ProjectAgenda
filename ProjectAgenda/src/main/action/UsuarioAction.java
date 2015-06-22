package action;

import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.validator.AssertTrue;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.End;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage.Severity;

import util.EncripiterSenha;
import entity.Usuario;

@Name("usuarioAction")
@Scope(ScopeType.APPLICATION)
public class UsuarioAction implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;

	@In
	private EntityManager entityManager;

	@In
	private FacesMessages facesMessages;

	@In(required = false, create = true)
	@Out(required = false)
	private Usuario usuario;

	public UsuarioAction() {

	}

	@Begin(join = true)
	public String novoUsuario() {
		this.setUsuario(new Usuario());
		return ("editarUsuario");
	}

	public String atualizarUsuario() {
		try {
			entityManager.refresh(usuario);
			facesMessages.add(Severity.WARN, "Usuário atualizado com sucesso");
			return ("atualizarUsuario");
		} catch (NoResultException e) {
			facesMessages.add(Severity.ERROR, "Não foi possível atualizar o susuário");
			return (null);
		}
	}

	public String excluirUsuario() {
		try {
			entityManager.remove(usuario);
			facesMessages.add(Severity.WARN, "Usuário excluído com sucess");
			return ("excluirUsuario");
		} catch (NoResultException e) {
			facesMessages.add(Severity.ERROR, "Não foi possível excluir o usuário");
			return (null);
		}
	}

	@End
	public String cadastrarUsuario() {
		try {
			usuario.setSenha(EncripiterSenha.encriptar(usuario.getSenha()));
			usuario.setConfSenha(EncripiterSenha.encriptar(usuario.getConfSenha()));

			entityManager.persist(usuario);
			
			facesMessages.add(Severity.INFO, "Usuário cadastrado com sucesso, favor checar e-mail!");
			return ("cadastarUsuario");
		} catch (NoResultException e) {
			facesMessages.add(Severity.ERROR, "Não foi possível cadastrar o usuáro");
			return (null);
		} catch (NoSuchAlgorithmException e) {
			facesMessages.add(Severity.ERROR, "Erro na criptografia da senha");
			return (null);
		} catch (IOException e) {
			facesMessages.add(Severity.ERROR, "Erro na criptografia da senha");
			return (null);
		}
	}

	@AssertTrue(message = "Senhas estão diferentes")
	public boolean isPasswordEquals() {
		if (usuario.getSenha() == null || usuario.getConfSenha() == null)
			return false;
		
		if (usuario.getSenha().equals(usuario.getConfSenha()))
			return true;
		else
			return false;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public FacesMessages getFacesMessages() {
		return facesMessages;
	}

	public void setFacesMessages(FacesMessages facesMessages) {
		this.facesMessages = facesMessages;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
