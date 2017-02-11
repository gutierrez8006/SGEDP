package sgdep.presentacion.controller;

import com.acme.pe.persistencia.dao.BussinessException;
import com.acme.pe.persistencia.dao.BussinessMessage;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sgdep.persistencia.dao.CustomerDetailDAO;
import sgdep.presentacion.json.JsonTransformer;

/**
 *
 * @author gutie026
 */
@Controller
public class CustomerDetailController {
    @Autowired
    JsonTransformer jsonTransformer;
    
    @Autowired
    CustomerDetailDAO customerDetailDAO;
    
    @RequestMapping(value = "/Customer/{idCustomer}/CustomerDetail", method = RequestMethod.GET, produces = "application/json")
    public void findXCustomer(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idCustomer") Long idCustomer){
        try {
            List<Map<String, Object>> customerDetails = customerDetailDAO.findXCustomer(idCustomer);
            String jsonSalida = jsonTransformer.toJson(customerDetails);
            if (customerDetails.size() > 0) {
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
            
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);
            
        } catch (BussinessException ex) {
            Set<BussinessMessage> bussinessMessage = ex.getBussinessMessages();
            String jsonSalida = jsonTransformer.toJson(bussinessMessage);

            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonSalida);
            } catch (IOException ex1) {
                Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
 
    }
}
