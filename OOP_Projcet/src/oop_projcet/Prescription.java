package oop_projcet;

public class Prescription extends Medicine {

    private String doctorSpecialization;

    //constructors
    public Prescription(String name, String composition,
            int dose, String doctorSpecialization) {
        this(name, composition, dose, 10, 0, doctorSpecialization);
    }

    public Prescription(String name, String composition, int dose,
            double price, int quantity, String doctorSpecialization) {
        super(name, composition, dose, price, quantity);
        setDoctorSpecialization(doctorSpecialization);
    }

    //setter
    public void setDoctorSpecialization(String doctorSpecialization) {
        //asuming you also want a unified format lowercase....
        this.doctorSpecialization = doctorSpecialization.toLowerCase();
    }

    //getter
    public String getDoctorSpecialization() {
        return doctorSpecialization;
    }

    //other methods
    @Override
    public String toString() {
        return "Prescription: \n" + super.toString()
                + "\n\tdoctor specialization: " + this.doctorSpecialization;
    }
}
