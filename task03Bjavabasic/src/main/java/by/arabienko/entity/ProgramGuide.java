package by.arabienko.entity;

import java.util.List;
import java.util.Objects;

public class ProgramGuide implements IGuid {
    private String nameChannel;
    private String country;
    private String dayOfWeek;
    private List<Program> program;

    public ProgramGuide(String nameChannel, String country, String dayOfWeek, List<Program> program) {
        this.nameChannel = nameChannel;
        this.country = country;
        this.dayOfWeek = dayOfWeek;
        this.program = program;
    }

    public ProgramGuide() {
    }

    public Program getProgram(int i) {
        return program.get(i);
    }

    public int getLengthProgram() {
        return program.size();
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) return true;
        if (obj==null || getClass()!=obj.getClass()) return false;
        ProgramGuide that = (ProgramGuide) obj;
        return Objects.equals(nameChannel, that.nameChannel) &&
                Objects.equals(country, that.country) &&
                Objects.equals(dayOfWeek, that.dayOfWeek) &&
                Objects.equals(program, that.program);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameChannel, country, dayOfWeek, program);
    }

    @Override
    public String toString() {
        return "\nProgramGuide: " + "\n" +
                "Channel= " + nameChannel + "\n" +
                "country= " + country + "\n" +
                "day Of Week= " + dayOfWeek + "\n" +
                "Guid program= " + program;
    }

    public String getNameChannel() {
        return nameChannel;
    }

    public class Program {
       private String nameProgram;
       private String time;

        public Program(String nameProgram, String time) {
            this.nameProgram = nameProgram;
            this.time = time;
        }


        @Override
        public boolean equals(Object o) {
            if (this==o) return true;
            if (o==null || getClass()!=o.getClass()) return false;
            Program program = (Program) o;
            return Objects.equals(nameProgram, program.nameProgram) &&
                    Objects.equals(time, program.time);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nameProgram, time);
        }

        @Override
        public String toString() {
            return "\n" + "Time= " + time + " : " +
                    "Name program= " + nameProgram;
        }
        public String getTime() {
            return time;
        }
    }
}
