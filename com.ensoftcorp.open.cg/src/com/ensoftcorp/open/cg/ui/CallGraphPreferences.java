package com.ensoftcorp.open.cg.ui;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.ensoftcorp.atlas.core.log.Log;
import com.ensoftcorp.open.cg.Activator;

/**
 * UI for setting call graph construction preferences
 * 
 * @author Ben Holland
 */
public class CallGraphPreferences extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
	
	// enable/disable call graph construction for libraries
	public static final String ENABLE_LIBRARY_CALL_GRAPH_CONSTRUCTION_BOOLEAN = "ENABLE_LIBRARY_CALL_GRAPH_CONSTRUCTION_BOOLEAN";
	public static final String ENABLE_LIBRARY_CALL_GRAPH_CONSTRUCTION_DESCRIPTION = "Enable Library Call Graph Construction";
	
	public static boolean isLibraryCallGraphConstructionEnabled(){
		boolean result = false; // library call graph construction is disabled by default
		try {
			result = Activator.getDefault().getPreferenceStore().getBoolean(ENABLE_LIBRARY_CALL_GRAPH_CONSTRUCTION_BOOLEAN);
		} catch (Exception e){
			Log.error("Error accessing call graph construction preferences.", e);
		}
		return result;
	}
	
	public CallGraphPreferences() {
		super(GRID);
	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Configure preferences for the Call Graph Toolbox plugin.");
	}

	@Override
	protected void createFieldEditors() {
		addField(new BooleanFieldEditor(ENABLE_LIBRARY_CALL_GRAPH_CONSTRUCTION_BOOLEAN, "&" + ENABLE_LIBRARY_CALL_GRAPH_CONSTRUCTION_DESCRIPTION, getFieldEditorParent()));
	}

}