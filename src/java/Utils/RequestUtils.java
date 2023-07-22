package Utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class RequestUtils {

    public static boolean possuiParametrosVazios(HttpServletRequest request) {
        Enumeration<String> paramNames = request.getParameterNames();

        while (paramNames.hasMoreElements()) {
            // Pega o próximo nome de parâmetro
            String paramName = paramNames.nextElement();

            // Pega o valor do parâmetro com base no nome
            String paramValue = request.getParameter(paramName);

            // Valida se o parâmetro está vazio
            if (paramValue == null || paramValue.trim().isEmpty()) {
                return true;
            }
        }

        return false; 
    }
}
