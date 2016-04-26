package global.tool;

import org.hibernate.type.Type;


public class QueryObject {
	
	private String propertyName;
	private Object object;
	private Type type;
	
	public QueryObject(String propertyName, Object object, Type type) {
		super();
		this.propertyName = propertyName;
		this.object = object;
		this.type = type;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}

}
