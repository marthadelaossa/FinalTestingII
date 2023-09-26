package utils;


import com.github.javafaker.Faker;

import java.util.Locale;

public class Datos {

    static Faker faker = new Faker(new Locale("en-U$"));

    private String correo;
    private String celular;
    private String nombre;
    private String apellido;

    private String direccion;

    private String city;
    private String estado;
    private String zipCode;
    private String SSN;




    public Datos() {

        //Datos aleatorios
        this.nombre = faker.name().firstName();
        this.apellido = faker.name().lastName();
        this.direccion = faker.address().fullAddress();
        this.city = faker.address().city();
        this.estado = faker.address().state();
        this.zipCode = faker.address().zipCode();
        this.celular=faker.phoneNumber().cellPhone();
        this.SSN = String.valueOf(faker.idNumber().valid() );

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCelular() {
        return celular;
    }

    public static Faker getFaker() {return faker;}

    public String getDireccion() {return direccion;}

    public String getCity() { return city;}

    public String getEstado() {return estado;}

    public String getZipCode() {return zipCode;}

    public String getSSN() {return SSN;}
}


