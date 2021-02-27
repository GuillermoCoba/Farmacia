package administrador;

import java.util.Objects;


public class Dproducto {

    private long Pr_Id;
    private String Pr_Nombre;
    private float Pr_Precio;
    private String Pr_Tipo;
    private String Pr_Presentacion;
    private String Pr_Laboratorio;
    private int Pr_Cantidad; 

    public Dproducto() {
    }

    public Dproducto(long Pr_Id, String Pr_Nombre, float Pr_Precio,String Pr_Tipo, String Pr_Presentacion, String Pr_Laboratorio, int Pr_Cantidad) {
    this.Pr_Id=Pr_Id;
    this.Pr_Nombre=Pr_Nombre;
    this.Pr_Precio=Pr_Precio;
    this.Pr_Tipo=Pr_Tipo;
    this.Pr_Presentacion=Pr_Presentacion;
    this.Pr_Laboratorio=Pr_Laboratorio;
    this.Pr_Cantidad=Pr_Cantidad;
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

    public void setPr_Nombre(String Pr_Nombre) {
        this.Pr_Nombre = Pr_Nombre;
    }

    public float getPr_Precio() {
        return Pr_Precio;
    }

    public void setPr_Precio(float Pr_Precio) {
        this.Pr_Precio = Pr_Precio;
    }

    public String getPr_Tipo() {
        return Pr_Tipo;
    }

    public void setPr_Tipo(String Pr_Tipo) {
        this.Pr_Tipo= Pr_Tipo;
    }

    public String getPr_Presentacion() {
        return Pr_Presentacion;
    }

    public void setPr_Presentacion(String Pr_Presentacion) {
        this.Pr_Presentacion = Pr_Presentacion;
    }
 public String getPr_Laboratorio() {
        return Pr_Laboratorio;
    }

    public void setPr_Laboratorio(String Pr_Laboratorio) {
        this.Pr_Laboratorio = Pr_Laboratorio;
    }
  public int getPr_Cantidad() {
        return Pr_Cantidad;
    }

    public void setPr_Cantidad(int Pr_Cantidad) {
        this.Pr_Cantidad = Pr_Cantidad;
    }

    @Override
    public String toString() {
        return "Dproducto{" + "Pr_Id=" + Pr_Id + ", Pr_Nombre=" + Pr_Nombre + ", Pr_Precio=" + Pr_Precio + ", Pr_Tipo=" + Pr_Tipo + ", Pr_Presentacion=" + Pr_Presentacion + ", Pr_Laboratorio=" + Pr_Laboratorio + ", Pr_Cantidad=" + Pr_Cantidad + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dproducto other = (Dproducto) obj;
        if (this.Pr_Id != other.Pr_Id) {
            return false;
        }
        if (Float.floatToIntBits(this.Pr_Precio) != Float.floatToIntBits(other.Pr_Precio)) {
            return false;
        }
        if (this.Pr_Cantidad != other.Pr_Cantidad) {
            return false;
        }
        if (!Objects.equals(this.Pr_Nombre, other.Pr_Nombre)) {
            return false;
        }
        if (!Objects.equals(this.Pr_Tipo, other.Pr_Tipo)) {
            return false;
        }
        if (!Objects.equals(this.Pr_Presentacion, other.Pr_Presentacion)) {
            return false;
        }
        if (!Objects.equals(this.Pr_Laboratorio, other.Pr_Laboratorio)) {
            return false;
        }
        return true;
    }

    
    
}
