/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import br.com.persistor.enums.FILTER_TYPE;
import br.com.persistor.enums.MATCH_MODE;
import br.com.persistor.enums.RESULT_TYPE;
import br.com.persistor.generalClasses.Restrictions;
import br.com.persistor.interfaces.Session;
import java.util.List;
import model.Contatos;
import sessionprovider.SessionProvider;

/**
 *
 * @author marcosvinicius
 */
public class ContatosDAO
{

    public boolean salva(Contatos contato)
    {
        Session session = SessionProvider.openSession();

        if (existe(contato.getId()))
            session.update(contato);
        else
            session.save(contato);

        session.commit();
        session.close();

        return (contato.saved || contato.updated);
    }

    public boolean delete(int id_contato)
    {
        Session session = SessionProvider.openSession();

        Contatos contato = session.onID(Contatos.class, id_contato);
        if (contato.getId() == 0)
        {
            session.close();
            return false;
        }

        session.delete(contato);
        session.commit();
        session.close();

        return contato.deleted;
    }

    public List<Contatos> search(String searchTerm)
    {
        Contatos contatos = new Contatos();

        Session session = SessionProvider.openSession();
        session.createCriteria(contatos, RESULT_TYPE.MULTIPLE)
                .add(Restrictions.like(FILTER_TYPE.WHERE, "nome", searchTerm, MATCH_MODE.ANYWHERE))
                .add(Restrictions.like(FILTER_TYPE.OR, "telefone", searchTerm, MATCH_MODE.ANYWHERE))
                .add(Restrictions.like(FILTER_TYPE.OR, "endereco", searchTerm, MATCH_MODE.ANYWHERE))
                .add(Restrictions.like(FILTER_TYPE.OR, "email", searchTerm, MATCH_MODE.ANYWHERE))
                .execute();
        session.close();

        return session.getList(contatos);
    }

    private boolean existe(int id_contato)
    {
        Session session = SessionProvider.openSession();
        int count = session.count(Contatos.class, "id = " + id_contato);
        session.close();

        return (count > 0);
    }

    public Contatos find(int id_contato)
    {
       Session session = SessionProvider.openSession();
       Contatos contatos = session.onID(Contatos.class, id_contato);
       session.close();
       
       return contatos;
    }
}
