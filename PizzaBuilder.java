package assignment2;
import javax.swing.*;

import javax.swing.border.*;

import java.awt.*;

import java.awt.event.*;

public class PizzaBuilder

{

	private static JFrame myFrame = new JFrame("Build a Pizza");

	private static JRadioButton small, medium, large;

	private static ButtonGroup bg;

	private static JLabel sizeList = new JLabel("Sizes List: ");

	private static JLabel Price = new JLabel("Total $ ");

	private static JLabel totPrice = new JLabel("0.0");

	private static JLabel topsPrice = new JLabel("Topping $ ");

	private static JLabel toppingsPrice = new JLabel("0.0");

	private static final double LARGE=16.49;

	private static final double MEDIUM=13.49;

	private static final double SMALL=10.49;

	private static final double MEATITEM=2.25;

	private static final double VEGITEM=1.75;

	private static int meattopping=0;

	private static int vegtopping=0;

	private static JCheckBox sausage, pepperoni, canadian_ham, anchovies;

	private static JCheckBox mushroom, green_pepper, onion, black_olive;

	public static void main(String[] args)

	{

		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		myFrame.setLayout(new FlowLayout());

		JPanel panelSizePrice = makeSizePricePanel();

		JPanel panelCheck = makePizzaPanel();

		myFrame.add(panelSizePrice);

		myFrame.add(panelCheck);

		myFrame.setSize(620,340);

		myFrame.setVisible(true);

	}

	/*

	 * The method,makeSizePricePanel that creates

	 * an panel with radio buttons and check boxes

	 * */

	private static JPanel makeSizePricePanel()

	{

		JPanel jp = new JPanel();

		jp.setLayout(new GridLayout(2,4));

		jp.setPreferredSize(new Dimension(575,100));

		//Set Small radio button as default checked

		small = new JRadioButton("Small", true);

		totPrice.setText(String.valueOf(SMALL));

		medium = new JRadioButton("Medium", false);

		large = new JRadioButton("Large", false);

		//Add radio buttons to the panel object, jp

		jp.add(sizeList);

		jp.add(small);

		jp.add(medium);

		jp.add(large);

		//Add pizzaSizeListen item listener class to the radio buttons

		small.addItemListener(new pizzaSizeListen());

		medium.addItemListener(new pizzaSizeListen());

		large.addItemListener(new pizzaSizeListen());

		//Create an object of ButtonGroup class

		bg = new ButtonGroup();

		//Add radio buttons to group,bg

		bg.add(small);bg.add(medium);bg.add(large);

		//Add labels to the jp panel

		jp.add(Price);

		jp.add(totPrice);

		jp.add(topsPrice);

		jp.add(toppingsPrice);

		return jp;

	} //end of makeSizePricePanel method

	/*

	 * Class pizzaSizeListen that implements the ItemListener class

	 * and override the itemStateChanged method.

	 * */

	private static class pizzaSizeListen implements ItemListener

	{

		public void itemStateChanged(ItemEvent i)

		{

			//Set sizePrice=SMALL

			double sizePrice=SMALL;

			//check if small radio is selected

			if(small.isSelected())

				sizePrice=SMALL;

			//check if medium radio is selected

			else if(medium.isSelected())

				sizePrice=MEDIUM;

			//check if large radio is selected

			else if(large.isSelected())

				sizePrice=LARGE;

			double pizzaPrice = sizePrice + Double.parseDouble(toppingsPrice.getText());

			totPrice.setText(String.valueOf(pizzaPrice));

		}

	} //end of pizzaSizeListen class

	/*

	 * The method, makePizzaPanel that create a panel

	 * to add check boxes of meat and vegetables.

	 * */

	private static JPanel makePizzaPanel()

	{

		JPanel jp = new JPanel();

		jp.setLayout(new GridLayout(2,4));

		jp.setPreferredSize(new Dimension(575,100));

		//Instantiate Check boxes and action listener

		sausage=new JCheckBox("Sausage");

		sausage.addItemListener(new pizzaToppingListen());

		pepperoni=new JCheckBox("Pepperoni");

		pepperoni.addItemListener(new pizzaToppingListen());

		canadian_ham=new JCheckBox("Canadian Ham");

		canadian_ham.addItemListener(new pizzaToppingListen());

		anchovies=new JCheckBox("Anchovies");

		anchovies.addItemListener(new pizzaToppingListen());

		mushroom=new JCheckBox("Mushroom");

		mushroom.addItemListener(new pizzaToppingListen());

		green_pepper=new JCheckBox("Green Pepper");

		green_pepper.addItemListener(new pizzaToppingListen());

		onion=new JCheckBox("Onion");

		onion.addItemListener(new pizzaToppingListen());

		black_olive=new JCheckBox("Black Olive");

		black_olive.addItemListener(new pizzaToppingListen());

		//Add check boxes to the jp panel

		jp.add(sausage);jp.add(pepperoni);jp.add(canadian_ham);jp.add(anchovies);

		jp.add(mushroom);jp.add(green_pepper);jp.add(onion);jp.add(black_olive);

		Border blackline = BorderFactory.createLineBorder(Color.black);

		jp.setBorder(blackline);

		return jp;

	}

	/*

	 * Class pizzaToppingListen that implements ItemListener

	 * and override the itemStateChanged method

	 * */

	private static class pizzaToppingListen implements ItemListener

	{

		public void itemStateChanged(ItemEvent i)

		{

			//Assign meattopping and vegtopping to 0

			meattopping=0;

			vegtopping=0;

			//increment meattoppings by 1 for meat check boxes

			if(sausage.isSelected())

				meattopping++;

			if(pepperoni.isSelected())

				meattopping++;

			if(canadian_ham.isSelected())

				meattopping++;

			if(anchovies.isSelected())

				meattopping++;

			//increment vegtopping by 1 for veg check boxes

			if(mushroom.isSelected())

				vegtopping++;

			if(green_pepper.isSelected())

				vegtopping++;

			if(onion.isSelected())

				vegtopping++;

			if(black_olive.isSelected())

				vegtopping++;

			double topsPrice = (meattopping * MEATITEM)+(vegtopping * VEGITEM);

			double sizePrice=0.0;

			//check if small radio button is selected

			if(small.isSelected())

			{

				totPrice.setText(String.valueOf(SMALL));

				sizePrice=SMALL;

			}

			//check if medium radio button is selected

			if(medium.isSelected())

			{

				totPrice.setText(String.valueOf(MEDIUM));

				sizePrice=MEDIUM;

			}

			//check if large radio button is selected

			if(large.isSelected())

			{

				totPrice.setText(String.valueOf(LARGE));

				sizePrice=LARGE;

			}

			//set toppings to toppingsPrice label

			//and update the totPrice with topsPrice and sizePrice

			toppingsPrice.setText(String.valueOf(topsPrice));

			totPrice.setText(String.valueOf(topsPrice + sizePrice));

		}

	}//end of the class,pizzaToppingListen

} //end of the class
