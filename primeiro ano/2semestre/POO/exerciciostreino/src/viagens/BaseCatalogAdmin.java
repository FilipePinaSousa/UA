package viagens;

import java.util.*;
public class BaseCatalogAdmin implements CatalogAdmin {

    private Map<String, Servico> servicos;

    public BaseCatalogAdmin() {
        servicos = new HashMap<>();
    }

   

    @Override
    public boolean verificarServico(String codigo) {
        return servicos.containsKey(codigo);
    }

   
    @Override
    public Servico removerServico(String codigo) {
        return servicos.remove(codigo);
    }

    @Override
    public Map<String, Servico> getServicos() {
        return servicos;
    }

   

    @Override
    public Iterator<String> iterator() {
        
        return servicos.keySet().iterator();
    }

    @Override
    public boolean registarServico(String codigo, Alojamento alojamento) {
        if (servicos.containsKey(codigo)) {
            return false;
        }
        servicos.put(codigo, alojamento);
        return false;
        
    }

    @Override
    public void registarServico(String codigo, Passeio passeio) {
        
       
            return;
        }
    

    @Override
    public void registarServico(String codigo, Aventura aventura) {
        
       
            return;
        
    }

    @Override
    public void registarServico(String codigo, MundoRural mundoRural) {
       
        
            return;
        
    }

    @Override
    public void registarServico(String codigo, PacoteServicos p1) {
            
        return ;
    }



    @Override
    public Servico sregistarServicoelecionarServico(String codigo) {
       throw new UnsupportedOperationException("Unimplemented method 'selecionarServico'"); 
        }



    @Override
    public Servico selecionarServico(String codigo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selecionarServico'");
    }
	
	
}