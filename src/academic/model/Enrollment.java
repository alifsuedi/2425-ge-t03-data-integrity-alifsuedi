package academic.model;

/**
 * @author 12S23025-Alif Aflah Suedi 
 * @author 12S23039-Prisca R. Manurung
 */
public class Enrollment {
    private String code;
    private String nim;
    private String years;
    private String semester;
   

    public Enrollment(String code, String nim, String years, String semester, String[] hal) {
        this.code = code;
        this.nim = nim;
        this.years = years;
        this.semester = semester;
     
    }

    public String getCode() {
        return code;
    }

    public String getNim() {
        return nim;
    }

    public String getYears() {
        return years;
    }

    @Override
    public String toString() {
    return code + "|" + nim + "|" + years + "|" + semester + "|None";
}

}
