package sgdep.presentacion.json;

/**
 *
 * @author gutie026
 */
public interface JsonTransformer {

    String toJson(Object data);

    Object fromJson(String json, Class clazz);
}   
