package sample;

public class Part {
    private String idPart;
    private  String idArticle;
    private String idName;
    private  String idStock;
    public Part (String idPart, String idArticle, String idName, String idStock ){
        this.idPart=idPart;
        this.idArticle=idArticle;
        this.idName=idName;
        this.idStock=idStock;
    }

    public Part() {

    }

    public String getIdPart() {
        return idPart;
    }

    public void setIdPart(String idPart) {
        this.idPart = idPart;
    }

    public String getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(String idArticle) {
        this.idArticle = idArticle;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    public String getIdStock() {
        return idStock;
    }

    public void setIdStock(String idStock) {
        this.idStock = idStock;
    }
}
