package org.springframework.learning.conversion;

/**
 * @author caoweiwei
 * @date 2020/10/21  9:38 上午
 */
public class PropertyEditorDemo {

	public static void main(String[] args) {
		String name = "name=cee";

		StringToPropertiesPropertyEditor editor = new StringToPropertiesPropertyEditor();
		editor.setAsText(name);
		System.out.println(editor.getValue());
		System.out.println(editor.getAsText());
	}
}
