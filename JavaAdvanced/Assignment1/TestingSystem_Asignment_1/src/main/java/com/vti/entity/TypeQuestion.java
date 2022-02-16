package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "type_question")
public class TypeQuestion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "type_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short typeId;

	@Column(name = "type_name", nullable = false)
	@Convert(converter = TypeNameConverter.class)
	private TypeName typeName;

	public TypeQuestion() {
	}

	/**
	 * @return the typeId
	 */
	public short getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(short typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return the typeName
	 */
	public TypeName getTypeName() {
		return typeName;
	}

	/**
	 * @param typeName the typeName to set
	 */
	public void setTypeName(TypeName typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "TypeQuestion [typeId=" + typeId + ", typeName=" + typeName + "]";
	}

	public enum TypeName {
		ESSAY("0"), MULTIPLE_CHOICE("1");

		private String typeName;

		private TypeName(String typeName) {
			this.typeName = typeName;
		}

		public String getTypeName() {
			return typeName;
		}

		public static TypeName toEnum(String sqlTypeName) {
			for (TypeName item : TypeName.values()) {
				if (item.getTypeName().equals(sqlTypeName)) {
					return item;
				}
			}
			return null;
		}
	}
	
}
