package cruds;

public interface ICRUD {
        Boolean crear(Object o);
        Object leer(Object o, int id);
        void listar(Object o);
        Boolean actualizar(Object o, int id);
        Boolean eliminar(Object o, int id);

}

