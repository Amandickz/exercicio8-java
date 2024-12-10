package classes;

import entities.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Worker {

    private String name;
    private WorkerLevel level;
    private double baseSalary;

    Departament departament;

    ArrayList<HourContract> contracts = new ArrayList<>();

    public Worker(String name, WorkerLevel level, double baseSalary, Departament departament) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.departament = departament;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", baseSalary=" + baseSalary +
                ", departament=" + departament +
                '}';
    }

    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        for(int i = 0; i < contracts.size(); i++) {
            HourContract c = (HourContract) contracts.get(i);
            if(contract.equals(c)){
                contracts.remove(i);
            }
        }
    }

    public double Income(Integer month, Integer year) {

        double addSalary = 0;

        for(HourContract contract : contracts) {
            Date contractDate = contract.getDate();
            Calendar cal = Calendar.getInstance();
            cal.setTime(contractDate);
            Integer c_year = cal.get(Calendar.YEAR);
            Integer c_month = 1 + cal.get(Calendar.MONTH);

            if(c_year.equals(year) && c_month.equals(month)) {
                addSalary += contract.getHours() * contract.getValuePerHour();
            }

        }
        return addSalary;
    }
}
