package sisepuede;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogueoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Recuperamos los datos que lleg�n en el request
		String vusuario = request.getParameter("usuario");
		String vclave = request.getParameter("clave");
		System.out.println(vusuario);
		System.out.println(vclave);
				
		// 2. "validamos" (creamos un poco de l�gica)
		boolean ok = false;
		// Posibilidades de iniciar sesion
		boolean[] posibilidades = {true, false, true, true};
		// Crea un nuevo generador de n�meros aleatorios
		Random posicion = new Random();
		int posi = posicion.nextInt(4);
		System.out.println("Posici�n: " + posi);
		ok = posibilidades[posi];
		System.out.println("OK: " + ok);
		
		// 3. Dependiendo del resultado de la validaci�n invocamos a bienvenida.jsp o rebotamos a logueo.jsp
		// para que un servlet pueda invocar a otro componente, usamos el famoso objeto RequestDispatcher (Despachador del request)
		if (ok == true) {
			System.out.println("Caso de �xito");
			
			// Cargamos informaci�n adicional en el request, antes de despacharlo
			String nombre = "Jos� Luis :)";
			Calendar c = Calendar.getInstance();
			c.set(1992, 1, 30);
			Date fecnac = c.getTime();
			
			// El primer par�metro representa el nombre del objeto en el request
			request.setAttribute("nombre", nombre);
			request.setAttribute("fecnac", fecnac);
			
			RequestDispatcher rd = request.getRequestDispatcher("/bienvenida.jsp");
			// Despachamos
			rd.forward(request, response);
		} else {
			System.out.println("Caso de error");
			
			// Cargamos otros datos al request
			String mensaje = "Usuario y/o clave erradas";
			request.setAttribute("msg", mensaje);
			
			RequestDispatcher rd = request.getRequestDispatcher("/logueo.jsp");
			rd.forward(request, response);
		}
	}

}