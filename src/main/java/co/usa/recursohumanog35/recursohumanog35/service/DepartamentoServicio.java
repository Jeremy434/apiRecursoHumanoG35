package co.usa.recursohumanog35.recursohumanog35.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.recursohumanog35.recursohumanog35.model.Departamento;
import co.usa.recursohumanog35.recursohumanog35.repository.DepartamentoRepositorio;

@Service
public class DepartamentoServicio {
    @Autowired
    DepartamentoRepositorio departamentoRepositorio;

    public List<Departamento> getAll(){
        return departamentoRepositorio.getAll();        
    }

    public Optional<Departamento>getDepartamento(int id){
        return departamentoRepositorio.getDepartamento(id);
    }

    public Departamento save(Departamento dpto){
        //Verificar si el id es nulo
        if (dpto.getNumId()==null) {
            return departamentoRepositorio.save(dpto);            
        }else{ //Veridico si existe el id o no en la base de datos
            Optional<Departamento> consulta=departamentoRepositorio.getDepartamento(dpto.getNumId());
            if (consulta.isEmpty()) {
                return departamentoRepositorio.save(dpto);
                
            } else {
                return dpto;                
            }
        }

    }


    public Departamento update(Departamento dpto)
        if ( dpto.getNumId()!=null){
            Optional<Departamento> consulta=departamentoRepositorio.getDepartamento(dpto.getNumId());
        if (!consulta.isEmpty()){
            if(dpto.getNombreDepartamento()!=null){
                consulta.get().setNombreDepartamento(dpto.getNombreDepartamento());
            }
            if (dpto.getFechaCreacionDate()!=null){
                consulta.get().setFechaCreacionDate(dpto.getFechaCreacionDate());
            }

            return departamentoRepositorio.save(consulta.get());
        }

    }
    return dpto;
    
    public boolean deleteDepartamento (int numId){
        Optional<Departamento>consulta=departamentoRepositorio.getDepartamento(numId)
    }

}
