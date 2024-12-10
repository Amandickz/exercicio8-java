import classes.Departament;
import classes.HourContract;
import classes.Worker;
import entities.WorkerLevel;

import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner scan = new Scanner(System.in);
        String name, level, departament;
        double baseSalary;

        System.out.print("Entre com o nome do departamento: ");
        departament = scan.nextLine();
        System.out.println("Entre com as informações do funcionário");
        System.out.print("Nome: ");
        name = scan.nextLine();
        System.out.print("Nível: ");
        level = scan.nextLine();
        System.out.print("Salário Base: ");
        baseSalary = scan.nextDouble();

        Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Departament(departament));

        System.out.println(worker.toString());

        System.out.print("Quantos contratos esse funcionário tem? ");
        int quant = scan.nextInt();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for(int i = 0; i < quant; i++) {

            System.out.println("Informações do contrato #" + (i + 1) + ": ");
            System.out.print("Data (dd/mm/yyyy): ");
            Date contractDate = sdf.parse(scan.next());
            System.out.print("Valor por hora: ");
            double valuePerHour = scan.nextDouble();
            System.out.print("Duração (horas): ");
            Integer hours = scan.nextInt();

            worker.addContract(new HourContract(contractDate, valuePerHour, hours));

        }

        /*SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Digite a data: ");
        Date contractDate = sdf.parse(scan.nextLine());
        System.out.print(contractDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(contractDate);
        int c_year = cal.get(Calendar.YEAR);
        int c_month = 1 + cal.get(Calendar.MONTH);
        System.out.println("\n" + c_month + " " + c_year);

        System.out.print("\nDigite a data: ");
        String monthAndYear = scan.next();
        int data = Integer.parseInt(monthAndYear.substring(0,2));
        int month = Integer.parseInt(monthAndYear.substring(3,5));
        int year = Integer.parseInt(monthAndYear.substring(6));

        System.out.println(data + "-" + month + "-" + year);*/



    }
}