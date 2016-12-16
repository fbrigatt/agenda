/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ContatosDAO;
import br.com.persistor.enums.FILTER_TYPE;
import br.com.persistor.enums.MATCH_MODE;
import br.com.persistor.enums.RESULT_TYPE;
import br.com.persistor.generalClasses.Restrictions;
import br.com.persistor.interfaces.Session;
import java.util.List;
import javax.validation.Valid;
import model.Contatos;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sessionprovider.SessionProvider;

/**
 *
 * @author marcosvinicius
 */
@Controller
public class ContatosController
{

    @RequestMapping(value = "/novo")
    public ModelAndView redirectCadastro()
    {
        ModelAndView mav = new ModelAndView("cadastro");
        mav.addObject("msgErro", null);
        mav.addObject("contato", new Contatos());

        return mav;
    }

    @RequestMapping(value = "/agenda")
    public ModelAndView redirectAgenda()
    {
        ModelAndView mav = new ModelAndView("agenda");
        mav.addObject("listContatos", new ContatosDAO().search(""));
        return mav;
    }

    @RequestMapping(value = "/alterarcontato")
    public ModelAndView redirectAlterar(@RequestParam(value = "id") int id_contato)
    {
        ModelAndView mav = new ModelAndView("cadastro");
        mav.addObject("msgErro", null);
        mav.addObject("contato", new ContatosDAO().find(id_contato));

        return mav;
    }

    @RequestMapping(value = "excluicontato")
    public ModelAndView excluiContato(@RequestParam(value = "id") int id_contato)
    {
        ContatosDAO cdao = new ContatosDAO();
        cdao.delete(id_contato);
        return new ModelAndView("redirect:agenda");
    }

    @RequestMapping(value = "/pesquisar", method = RequestMethod.POST)
    public ModelAndView pesquisar(@RequestParam(value = "searchTerm") String busca)
    {
        ModelAndView mav = new ModelAndView("agenda");
        mav.addObject("listContatos", new ContatosDAO().search(busca));
        return mav;
    }

    @RequestMapping(value = "/salvacontato", method = RequestMethod.POST)
    public ModelAndView salvar(@Valid Contatos contato, BindingResult result)
    {
        if (result.hasErrors())
        {
            ModelAndView mavErro = new ModelAndView("cadastro");
            mavErro.addObject("msgErro", result.getFieldErrors().get(0).getDefaultMessage());
            mavErro.addObject("contato", contato);
            return mavErro;
        }

        ContatosDAO contatosDAO = new ContatosDAO();

        if (!contatosDAO.salva(contato))
        {
            ModelAndView mavErro = new ModelAndView("cadastro");
            mavErro.addObject("msgErro", "Ocorreu um problema ao salvar o contato");
            mavErro.addObject("contato", contato);
            return mavErro;
        }

        return new ModelAndView("redirect:agenda");
    }
}
