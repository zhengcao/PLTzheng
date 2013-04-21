package columbia.plt.tt;

public class TimeFrame {

  private int years;
  private int months;
  private int days;
  private int hours;
  private int minutes;
  
  
  public TimeFrame() {
  	this.years = 0;
  	this.months = 0;
  	this.days = 0;
  	this.hours = 0;
  	this.minutes = 0;
  }
  
  public TimeFrame(int years, int months, int days, int hours, int minutes) {
  	this.years = years;
  	this.months = months;
  	this.days = days;
  	this.hours = hours;
  	this.minutes = minutes;
  }
  
  public TimeFrame(String timeFrameConst) {
    this.years = 0;
    this.months = 0;
    this.days = 0;
    this.hours = 0;
    this.minutes = 0;  	
    String[] timeFrameParts = timeFrameConst.split("\\+");
                  	
    for (int i = 0; i < timeFrameParts.length; i++) {
      int index = timeFrameParts[i].toLowerCase().indexOf("years");
      if (index >= 0)
        this.years += Integer.parseInt(timeFrameParts[i].substring(0, index - 1).trim());
                                        		
      index = timeFrameParts[i].toLowerCase().indexOf("months");
      if (index >= 0)
        this.months += Integer.parseInt(timeFrameParts[i].substring(0, index - 1).trim());
                                                                		
      index = timeFrameParts[i].toLowerCase().indexOf("days");
      if (index >= 0)
        this.days += Integer.parseInt(timeFrameParts[i].substring(0, index - 1).trim());
                                                                                      		
      index = timeFrameParts[i].toLowerCase().indexOf("hours");
      if (index >= 0)
        this.hours += Integer.parseInt(timeFrameParts[i].substring(0, index - 1).trim());
                                                                                                            		
      index = timeFrameParts[i].toLowerCase().indexOf("minutes");
      if (index >= 0)
        this.minutes += Integer.parseInt(timeFrameParts[i].substring(0, index - 1).trim());
    }
  }
  
  public TimeFrame(Date start, Date end) {
  	initialize(start, end);
  }
  
  public TimeFrame(String start, String end) {
  	initialize(new Date(start), new Date(end));
  }
  
  public TimeFrame(Date start, String end) {
  	initialize(start, new Date(end));
  }
  
  public TimeFrame(String start, Date end) {
  	initialize(new Date(start), end);
  }
  
  
  public int getYears() { return this.years; }
  public void setYears(int years) { this.years = years; }
  public int getMonths() { return this.months; }
  public void setMonths(int months) { this.months = months; }
  public int getDays() { return this.days; }
  public void setDays(int days) { this.days = days; }
  public int getHours() { return this.hours; }
  public void setHours(int hours) { this.hours = hours; }
  public int getMinutes() { return this.minutes; }
  public void setMinutes(int minutes) { this.minutes = minutes; }
  
  
  private void initialize(Date start, Date end) {
  	this.years = end.getYear() - start.getYear();
  	this.months = end.getMonth() - start.getMonth();
  	this.days = end.getDay() - start.getDay();
  	this.hours = end.getHour() - start.getHour();
  	this.minutes = end.getMinute() - start.getMinute();
  }
  
  @Override
  public String toString() {
  	return "Years: " + Integer.toString(years) + ", Months: " + Integer.toString(months) + ", Days: " + Integer.toString(days) + ", Hours: " + Integer.toString(hours) + ", Minutes: " + Integer.toString(minutes);
  }
}
