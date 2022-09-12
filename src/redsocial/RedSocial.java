package redsocial;

import java.util.ArrayList;
import java.util.Scanner;

public class RedSocial {

	static Comment comentario;
	static User activeUser;
	static Scanner teclado;
	static User usuario;
	static Post post;
	static int contador;

	static ArrayList<User> friends;
	static ArrayList<User> usuarios;
	static ArrayList<Post> posts;
	static ArrayList<Comment> comentarios;

	public static void main(String[] args) {

		posts = new ArrayList<>();
		comentarios = new ArrayList<>();
		usuarios = new ArrayList<>();
		friends = new ArrayList<>();
		teclado = new Scanner(System.in);
		boolean salir = false;

		/**
		 * Load the initial data
		 */
		addInitialUsers();

		/**
		 * Menu options
		 */

		do {
			System.out.println("============================");
			System.out.println("== Selecciona una Opción: ==");
			System.out.println("============================");

			System.out.println(
					" 1. Añadir Usuarios\n 2. Crear una publicación \n 3. Mostrar publicaciones \n 4. Eliminar Usuario \n 5. Mostrar Usuarios \n 6. Selecciona un usuario \n 7. Mostrar Amigos \n 8. Agregar Amigo \n 9. Eliminar \n 10. Mostrar Post \n 11. Mostrar Comentarios \n 0. Salir");

			int option = teclado.nextInt();

			switch (option) {

			case 1:
				registerUser();
				break;

			case 2:
				addPost();
				break;

			case 3:
				showAllPost();
				break;

			case 4:
				deleteUser();
				break;

			case 5:
				userList();
				break;

			case 6:
				selectUser();
				break;

			case 7:
				showFriends();
				break;

			case 8:
				addFriend();
				break;

			case 9:
				delete();
				break;

			case 10:
				showPost();
				break;
				
			case 11:
				showComment();
				break;
				
			case 12:
				createComment();
				break;

			case 0:
				salir = true;
				System.out.println("Hasta Luego");
			}

		} while (!salir);
	}

	/**
	 * Register a new user
	 */
	static void registerUser() {
		teclado.nextLine();
		System.out.println("Introduce el nombre de usuario: ");
		String name = teclado.nextLine();
		usuario = new User(name);
		usuarios.add(usuario);
	}

	/**
	 * Show the user in the app
	 */
	static void userList() {

		if (usuarios.isEmpty()) {
			System.out.println("Debes de registrar por lo menos un usuario");
			registerUser();
		}

		System.out.println("============================");
		System.out.println("= Listado de los usuarios ==");
		System.out.println("============================");

		for (User u : usuarios) {
			System.out.println(contador++ + ". " + u);
		}
		System.out.println("============================");
		contador = 0;
	}

	/**
	 * Select user for use the app
	 */
	static void selectUser() {
		System.out.println("============================");
		System.out.println("= Selecciona un usuario:  ==");
		System.out.println("============================");
		for (User u : usuarios) {
			System.out.println(contador++ + "." + u);
		}
		int u = teclado.nextInt();
		activeUser = usuarios.get(u);
		contador = 0;
		System.out.println("============================");
		System.out.println("Has seleccionado el usuario: " + usuarios.get(u));
		System.out.println("============================");

	}

	/**
	 * Show friends
	 */
	static void showFriends() {
		if (activeUser == null) {
			selectUser();
		}

		System.out.println("=========================");
		System.out.println("= Amigos de " + activeUser.getName() + " ==");
		System.out.println("=========================");

		System.out.println(activeUser.showFriends());

		System.out.println("=========================");
	}

	/**
	 * Create a new post
	 */
	static void addPost() {

		if (activeUser == null) {
			selectUser();
		}

		teclado.nextLine();
		System.out.println("Introduce el titulo del post: ");
		String title = teclado.nextLine();

		System.out.println("Selecciona una opción: ");
		boolean salir = false;

		System.out.println("Selecciona una Opción: ");
		System.out.println(" 1. Imagen\n 2. Video \n 3. Texto\n");

		int option = teclado.nextInt();

		switch (option) {

		case 1:
			System.out.println("Introduce el alto de la imagen: ");
			int alto = teclado.nextInt();
			System.out.println("Introduce el ancho de la imagen: ");
			int ancho = teclado.nextInt();
			post = new Image(title, alto, ancho);
			posts.add(post);
			activeUser.setPosts(posts);
			System.out.println("Se agrego correctamente tu imagen");
			break;

		case 2:
			teclado.nextLine();
			System.out.println("Introduce la calidad del video: ");
			String quality = teclado.nextLine();
			System.out.println("Introduce la duracion en segundos: ");
			int seconds = teclado.nextInt();
			post = new Video(title, quality, seconds);
			posts.add(post);
			activeUser.setPosts(posts);
			System.out.println("Se agrego correctamente tu post");
			break;

		case 3:
			teclado.nextLine();
			System.out.println("Introduce el contenido del Post: ");
			String contenido = teclado.nextLine();

			post = new Text(title, contenido);
			posts.add(post);
			activeUser.setPosts(posts);
			System.out.println("Se agrego correctamente tu post");
			break;

		default:
			System.out.println("No se pudo guardar tu post!");
		}

	}

	/**
	 * Add a new friend for the selected user.
	 */
	static void addFriend() {

		if (activeUser == null) {
			System.out.println("No has seleccionado ningun usuario");
			selectUser();
		}

		System.out.println("Selecciona al usuario al que quieres agregar");
		for (User u : usuarios) {

			System.out.println(contador++ + "." + u);
		}
		int u = teclado.nextInt();
		usuario = usuarios.get(u);

		friends.add(usuario);
		activeUser.setFriends(friends);
		contador = 0;

		showFriends();
	}

	/**
	 * Show all the post
	 */
	static void showPost() {

		if (activeUser == null) {

			System.out.println("Debes seleccionar un usuario: ");
			selectUser();

		}

		if (activeUser.getPosts() == null) {

			System.out.println("El usuario no tiene post");
			selectUser();

		}

		for (Post post : activeUser.getPosts()) {
			System.out.println(contador++ + ". " + post.getTitle() + " Tipo de contenido: " + post.getType());
		}

		contador = 0;

	}

	/**
	 * Show all post
	 */
	static void showAllPost() {
		System.out.println("=========================");
		System.out.println("= Post de los usuarios ==");
		System.out.println("=========================");

		for (Post post : posts) {
			System.out.println(contador++ + ". " + post.getTitle() + " Tipo de contenido: " + post.getType());
		}
		System.out.println("=========================");
		contador = 0;
	}

	/**
	 * Delete users
	 */
	static void deleteUser() {
		System.out.println("Selecciona el usuario a eliminar: ");
		for (User u : usuarios) {
			System.out.println(contador++ + "." + u);
		}
		int u = teclado.nextInt();
		contador = 0;
		System.out.println("Has eliminado al usuario: " + usuarios.remove(u));
	}

	/**
	 * Delete Post for selected user.
	 */

	static void delete() {

		teclado.nextLine();
		System.out.println("=========================");
		System.out.println("= Que quieres eliminar ==");
		System.out.println("=========================");
		System.out.println(" 1. Usuario \n 2. Post \n 3. Comentario\n");

		int option = teclado.nextInt();

		switch (option) {

		case 1:
			deleteUser();
			break;

		case 2:
			deletePost();
			break;

		case 3:
			deleteComment();
			break;

		default:
			System.out.println("No se pudo eliminar!");
		}

	}

	/**
	 * Delete post
	 */
	static void deletePost() {

		System.out.println("==================================");
		System.out.println("= Selecciona el POST a eliminar ==");
		System.out.println("==================================");

		if (activeUser == null) {
			System.out.println("No has seleccionado ningun usuario");
			selectUser();
		}

		if (activeUser.getPosts() == null) {
			System.out.println("El usuario no tiene post");
			selectUser();
		}

		for (Post p : activeUser.getPosts()) {
			System.out.println(contador++ + "." + "Tipo Conenido: " + p.getType() + " ,Titulo: " + p.getTitle()
					+ " ,Publicado el: " + p.getDate());
		}

		int p = teclado.nextInt();
		contador = 0;
		System.out.println("Has eliminado el post: " + activeUser.getPosts().remove(p));

	}

	/**
	 * Delete Comment
	 */

	static void deleteComment() {

		if (activeUser == null) {
			System.out.println("No has seleccionado ningun usuario");
			selectUser();
		}

		if (activeUser.getComments() == null) {
			System.out.println("No has hecho ningun comentario");
		} else {
			System.out.println("Selecciona el comentario a eliminar: ");

			for (Comment comment : activeUser.getComments()) {
				System.out.println(contador++ + "." + comment.getTitle());
			}

			int c = teclado.nextInt();
			contador = 0;
			activeUser.getComments().remove(c);
			System.out.println("Has eliminado el comentario");
		}

	}

	
	
	static void showComment() {
		
		if (activeUser == null) {
			System.out.println("No has seleccionado ningun usuario");
			selectUser();
		}
		
		if (activeUser.getComments() == null) {
			System.out.println("No has hecho ningun comentario");
		}else {
			for (Comment comment : activeUser.getComments()) {
				System.out.println(contador++ + "." + comment.getTitle());
			}
		}

		contador = 0;
	}
	
	
	static void createComment() {
		System.out.println("==================================");
		System.out.println("= Selecciona el POST a comentar ==");
		
		if (activeUser == null) {
			selectUser();
		}
		
		showAllPost();
		int post = teclado.nextInt();
	
		
		System.out.println("Introduce tu comentario: ");
		String title = teclado.nextLine();
		comentario.setTitle(title);
		comentario.setOwner(activeUser);
		
		
		
		activeUser.setComments(comentarios);
		
		
		
		
		
	}
	
	/**
	 * Register the initial users
	 */
	static void addInitialUsers() {
		User pepe = new User("Pepe");
		usuarios.add(pepe);
		User manolita = new User("Manolita");
		usuarios.add(manolita);
		User juan = new User("Juan");
		usuarios.add(juan);
		User julia = new User("Julia");
		usuarios.add(julia);
		User sandra = new User("Sandra");
		usuarios.add(sandra);
		User diego = new User("Diego");
		usuarios.add(diego);
		User carlos = new User("Carlos");
		usuarios.add(carlos);

		// seguidores de pepe
		ArrayList<User> followedpepe = new ArrayList<>();

		followedpepe.add(manolita);
		followedpepe.add(diego);

		pepe.setFriends(followedpepe);

		// seguidores de manolita
		ArrayList<User> followedmanolita = new ArrayList<>();

		followedmanolita.add(juan);
		followedmanolita.add(diego);

		manolita.setFriends(followedmanolita);

		// post de pepe
		Post post1 = new Image("Selfie.jpg", new ArrayList<Comment>(), 400, 450);
		posts.add(post1);
		pepe.setPosts(posts);

		Post post2 = new Text("Hoy sali de acampada", "Hoy sali de acampada", new ArrayList<Comment>());
		posts.add(post2);
		pepe.setPosts(posts);

		Comment c1 = new Comment("Menuda suerte", diego);
		Comment c2 = new Comment("Espero que no lloviese", manolita);
		comentarios.add(c1);
		comentarios.add(c2);

		pepe.setComments(comentarios);

		// añadimos los comentarios al post de pepe
		pepe.setComments(comentarios);

		// añadimos la lista de post a pepe
		pepe.setComments(comentarios);

		// añadimos amigos de pepe a pepe
		pepe.setFriends(followedpepe);

		// añadimos amigos de manolita a manolita
		manolita.setFriends(followedmanolita);
	}

}
