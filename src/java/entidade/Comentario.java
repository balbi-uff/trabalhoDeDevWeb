package entidade;

public class Comentario {

    private int id;
    private String comentario;
    private String data;
    private int idusuario;
    private int idcategoria;
    private String nomeususario;
    private String nomeCategoria;

    public Comentario() {
        this.id = 0;
        this.comentario = "";
        this.data = "";
        this.idcategoria = 0;
        this.idusuario = 0;
        this.nomeususario = "";
        this.nomeCategoria = "";
    }

    public Comentario(int id, String comentario, String data, int idusuario, int idcategoria) {
        this.id = id;
        this.comentario = comentario;
        this.data = data;
        this.idusuario = idusuario;
        this.idcategoria = idcategoria;
        this.nomeususario = "";
        this.nomeCategoria = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
        public String getNomeususario() {
        return nomeususario;
    }

    public void setNomeususario(String nomeususario) {
        this.nomeususario = nomeususario;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
    
    

    
}
