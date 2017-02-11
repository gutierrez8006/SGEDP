package com.acme.pe.persistencia.util;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.transform.BasicTransformerAdapter;

/**
 *
 * @author gutie026
 */
public class AliasToEntityLinkedMapBasicTransformerAdapter extends BasicTransformerAdapter {
    public static final AliasToEntityLinkedMapBasicTransformerAdapter INSTANCE = new AliasToEntityLinkedMapBasicTransformerAdapter();
    @Override
    public Object transformTuple(Object[] tuple, String[] aliases) {
        Map result = new LinkedHashMap(tuple.length);
        
        for (int i = 0; i < tuple.length; i++) {
            String alias = aliases[i];
            
            if (alias != null) {
                //AliasValor<String, Object> aliasValor = new AliasValor<>(alias, tuple[i]);
                //result.put(i, aliasValor);
                result.put(alias, tuple[i]);
            }
            
        }
        return result;
    }

    @Override
    public List transformList(List list) {
       return list;
    }
    
    private Object readResolve() {
        return INSTANCE;
    }
    @Override
    public boolean equals(Object other) {
        return other != null && AliasToEntityLinkedMapBasicTransformerAdapter.class.isInstance(other);
    }

    @Override
    public int hashCode() {
        return getClass().getName().hashCode();
    }
}
