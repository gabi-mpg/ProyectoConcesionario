package controllers;

public interface ICRUD {
        Boolean crear(Object o);
        Object leer(Object o, int id);
        Object leerString(Object o, String pk);
        void listar(Object o);
        Boolean actualizar(Object o, int id);
        Boolean eliminar(Object o, int id);

}

