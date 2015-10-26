package com.somallg.core.impl.workflowprocess;

import com.day.cq.workflow.WorkflowException;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.WorkItem;
import com.day.cq.workflow.exec.WorkflowProcess;
import com.day.cq.workflow.metadata.MetaDataMap;

public class MyProcess implements WorkflowProcess {

	@Override
	public void execute(WorkItem item, WorkflowSession session, MetaDataMap args)
			throws WorkflowException {
		// TODO Auto-generated method stub
	}
}
