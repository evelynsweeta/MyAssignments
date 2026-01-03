package week3.day2.Assignments;

public class Elements extends Button {

	public static void main(String[] args) {
		Elements e=new Elements();
		e.click();
		e.setText("base class");
		e.submit();
		TextField t=new TextField();
		t.Text();
		t.click();
		t.setText("using textfield object");
		CheckBoxButton c=new CheckBoxButton();
		c.clickCheckButton();
		c.submit();
		c.click();
		c.setText("using CheckBoxButton object");
		RadioButton r=new RadioButton();
		r.selectRadioButton();	
		r.click();
		r.setText("using RadioButton object");
		r.submit();

	}

}
