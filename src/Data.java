import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Data")
public class Data extends HttpServlet {
	private static final long serialVersionUID =5120121212L;
       
    
    public Data() {
        super();
       
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	      Date dataNascimento = null;
		try {
			dataNascimento = formato.parse(request.getParameter("num"));
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 
	      int idade = calculaIdade(dataNascimento);
	      //variavel que recebe idade:
	      
	      PrintWriter out = response.getWriter();
	      out.println("Sua idade é de "+idade+" anos");
	   }

	public static int calculaIdade(java.util.Date dataN) {

	    Calendar dataNasc = Calendar.getInstance();  
	    dataNasc.setTime(dataN); 
	    Calendar dataAtual = Calendar.getInstance();  

	    int idade = dataAtual.get(Calendar.YEAR) - dataNasc.get(Calendar.YEAR); 

	    if (dataAtual.get(Calendar.MONTH) < dataNasc.get(Calendar.MONTH)) {
	      idade--;  
	    } 
	    else
	    { 
	        if (dataAtual.get(Calendar.MONTH) == dataNasc.get(Calendar.MONTH) && dataAtual.get(Calendar.DAY_OF_MONTH) < dataNasc.get(Calendar.DAY_OF_MONTH)) {
	            idade--; 
	        }
	    }

	    return idade;
	}
}

printf("hello World");
