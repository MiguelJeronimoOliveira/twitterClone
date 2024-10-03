package br.com.Beans;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.Entities.EditedEnum;
import br.com.Entities.Post;
import br.com.Dao.PostDAO;

@ManagedBean(name = "postBean")
@ViewScoped
public class PostBean {

	private Post post = new Post();
	private PostDAO<Post> postDao = new PostDAO<Post>();
	private List<Post> posts = new ArrayList<Post>();
	private Date diaAtual = new Date();
	private Date horaAtual = new Date();
	
	@PostConstruct
	public void ExibirTimeLine() {
		posts = new ArrayList<Post>();
		posts = postDao.TimeLine(Post.class);
	}
	
	public String Postar() {	
		post.setAutor(postDao.GetUsuario());
		post.setNomeAutor(postDao.GetUsuario().getUsername());
		postDao.Postar(post);
		post = new Post();
		ExibirTimeLine();
		return "";
	}
	
	public String DeletarPost() {
		if(!postDao.GetUsuario().getUsername().equals(post.getNomeAutor())) {
			post = new Post();
			return "";
		}
		postDao.Deletar(post);
		post = new Post();
		ExibirTimeLine();
		return "";
	}
	

	public String EditarPost() {
		if(!postDao.GetUsuario().getUsername().equals(post.getNomeAutor())) {
			post = new Post();
			return "";
		}
		post.setEditado(EditedEnum.Editado);
		post = postDao.Editar(post);
		post.setDiaCriacao(diaAtual);
		post.setTempoCriacao(horaAtual);
		return "";			
		
	}
	
	//metodo de pesquisar post
	
	public LocalTime HoraAtual() {
		return LocalTime.now();
	}
	
	public LocalTime TempoLimite() {
		LocalTime Tempo = HoraAtual().plusMinutes(5);
		return Tempo;
	}
	
 
	
	//getters e setters
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public PostDAO<Post> getPostDao() {
		return postDao;
	}

	public void setPostDao(PostDAO<Post> postDao) {
		this.postDao = postDao;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	

}
