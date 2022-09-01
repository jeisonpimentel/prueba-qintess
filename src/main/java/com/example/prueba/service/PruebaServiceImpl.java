package com.example.prueba.service;

import com.example.prueba.entity.Prueba1;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PruebaServiceImpl {

    public Map<Object, List<Prueba1>> getDatosAgrupadosPorEdad(){
        List<Prueba1> prueba1  = createPLayers();
        return getResult( prueba1);
    }

    public Map<Object, List<Prueba1>> ordernadosAlfabeticamente(){
        List<Prueba1> prueba1        = createPLayers();
        Collections.sort( prueba1, (Prueba1 p, Prueba1 p1) -> p.getName().compareTo( p1.getName() ));
        return getResult( prueba1);
    }

    public Map<Object, List<Prueba1>> getResult( List<Prueba1> prueba1 ){

        Map<Object, List<Prueba1>> response = new HashMap<>();
        if( !prueba1.isEmpty() ){
            List<Integer> keys = new ArrayList<>();
            prueba1.forEach( p1 -> {
                if( !keys.contains( p1.getAge() ) ){
                    keys.add( p1.getAge() );
                }
            });

            for(Integer k : keys ){
                List<Prueba1> pruebaAgrupado = new ArrayList<>();
                for( Prueba1 p1: prueba1 ){
                    if( k == p1.getAge()) {
                        pruebaAgrupado.add(p1);
                    }
                }
                response.put(k, pruebaAgrupado);
            }
        }
        return response;
    }

    private List<Prueba1> createPLayers() {
        List<Prueba1> nationalTeam = new ArrayList<>();
        nationalTeam.add(new Prueba1(37, "Claudio Bravo"));
        nationalTeam.add(new Prueba1(36, "Jean Beausejour"));
        nationalTeam.add(new Prueba1(34, "Gonzalo Jara"));
        nationalTeam.add(new Prueba1(33, "Gary Medel"));
        nationalTeam.add(new Prueba1(32, "Mauricio Isla"));
        nationalTeam.add(new Prueba1(31, "Charles Aránguiz"));
        nationalTeam.add(new Prueba1(33, "Arturo Vidal"));
        nationalTeam.add(new Prueba1(34, "Matias Fernandez"));
        nationalTeam.add(new Prueba1(36, "Jorge Valdivia"));
        nationalTeam.add(new Prueba1(31, "Alexis Sánchez"));
        nationalTeam.add(new Prueba1(30, "Eduardo Vargas"));
        return nationalTeam;
    }

}
