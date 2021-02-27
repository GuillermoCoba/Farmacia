package administrador;


public class Ddetalle_venta {

    private long Ve_Id;
    private long Pr_Id;
    private String Pr_Nombre;
    private String Pr_Presentacion;
    private float Pr_Precio;
    private int Pr_Cantidad; 
    private float Pr_Total;

    public Ddetalle_venta () {
    }

    public Ddetalle_venta (long Ve_Id, long Pr_Id, String Pr_Nombre, String Pr_Presentacion,float Pr_Precio,int Pr_Cantidad,float Pr_Total) {
    this.Ve_Id=Ve_Id;
    this.Pr_Id=Pr_Id;
    this.Pr_Nombre=Pr_Nombre;
    this.Pr_Presentacion=Pr_Presentacion;
    this.Pr_Precio=Pr_Precio;
    this.Pr_Cantidad=Pr_Cantidad;
    this.Pr_Total=Pr_Total;
    }

  

 
      public long getVe_Id() {
        return Ve_Id;
    }

    public void setVe_Id(long Ve_Id) {
        this.Ve_Id = Ve_Id;
    }

    public long getPr_Id() {
        return Pr_Id;
    }

    public void setPr_Id(long Pr_Id) {
        this.Pr_Id = Pr_Id;
    }

    public String getPr_Nombre() {
        return Pr_Nombre;
    }

    public void setPrNombre(String Pr_Nombre) {
        this.Pr_Nombre = Pr_Nombre;
    }

    public float getPr_Precio() {
        return Pr_Precio;
    }

    public void setPr_Precio(float Pr_Precio) {
        this.Pr_Precio = Pr_Precio;
    }


    public String getPr_Presentacion() {
        return Pr_Presentacion;
    }

    public void setPr_Presentacion(String Pr_Presentacion) {
        this.Pr_Presentacion = Pr_Presentacion;
    }
 
  public int getPr_Cantidad() {
        return Pr_Cantidad;
    }

    public void setPr_Cantidad(int Pr_Cantidad) {
        this.Pr_Cantidad = Pr_Cantidad;
    }
  public float getPr_Total() {
        return Pr_Total;
    }

    public void setPr_Total(float Pr_Total) {
        this.Pr_Total = Pr_Total;
    }
}
