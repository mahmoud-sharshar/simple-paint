package eg.edu.alexu.csd.oop.draw.cs46_47;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import eg.edu.alexu.csd.oop.draw.Shape;

public class Ellipse extends Shapes2D {

	private shapeFactory factory;

	public Ellipse() {
		super();
		factory = new shapeFactory();
		this.getProperties().put("type", 3.0);
	}

	@Override
	public void draw(Graphics canvas) {

		SurroundingRectangle();
		Graphics2D graph = (Graphics2D) canvas;
		graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graph.setStroke(new BasicStroke((float) (double) this.getProperties().get("thickness")));
		graph.setComposite(AlphaComposite.SrcOver.derive((float) (double) this.getProperties().get("transparent")));
		if (this.getFillColor() == null) {
			graph.setColor(this.getColor());
			graph.draw(new Ellipse2D.Double(this.getPosition().getX(), this.getPosition().getY(), this.width,
					this.height));
		}
		if (this.getFillColor() != null) {
			graph.setColor(this.getFillColor());
			graph.fill(new Ellipse2D.Double(this.getPosition().getX(), this.getPosition().getY(), this.width,
					this.height));
		}

	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Shape newShape = factory.createShape("Ellipse");
		newShape = this.cloing("Ellipse", this);
		return newShape;
	}

}
