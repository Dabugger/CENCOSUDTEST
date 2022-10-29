package cl.easy.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
		/**
		 *  Buenas tardes Franco
		 * Te escribo para enviarte los datos el test de conocimientos que te comenté en la entrevista.
		 *
		 * Quisiera un sistema API Rest con java 11, Spring boot y Maven que me permita lista usuarios de un API externa. El sistema debe contar con dos métodos.
		 *
		 *     Método GET que liste todos los usuarios que existen en el API externa.
		 *     Método POST que permita buscar datos de un usuario por ID y por nombre.
		 *
		 * También quisiera tener un poco de seguridad en el API que vas a crear, para eso es necesario que se envíe un API token en el header en cada request.
		 *
		 * Te comento que el API tiene dos paginas con data de usuarios, tu deberás hacer la búsqueda en las dos páginas para poder satisfacer los dos métodos antes mencionados.
		 *
		 * El API externa ---> https://reqres.in/api/users?page=1 y https://reqres.in/api/users?page=2 */

		System.out.println("Start");
	}

}
