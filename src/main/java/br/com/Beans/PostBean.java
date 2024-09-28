package br.com.Beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.Entities.Post;
import br.com.GenericDao.PostDAO;

@ManagedBean(name = "postBean")
@ViewScoped
public class PostBean {

	private Post post = new Post();
	private PostDAO<Post> postDao = new PostDAO<Post>();
	private List<Post> posts = new ArrayList<Post>();
	
	@PostConstruct
	public void ExibirTimeLine() {
		posts = postDao.TimeLine(Post.class);
	}
	
	public String Postar() {
		postDao.Postar(post);
		post = new Post();
		ExibirTimeLine();
		return "";
	}
	
	public String DeletarPost() {
		postDao.Deletar(post);
		ExibirTimeLine();
		return "";
	}
	
	public String EditarPost() {
		// condicao de so poder editar um post de ate 5 minutos atras
		post = postDao.Editar(post);
		return "";
	}
	
	//metodo de pesquisar post
	

	
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
