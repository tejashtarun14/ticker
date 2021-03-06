/**
 * Copyright 2017 esutdal

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package org.reactivetechnologies.ticker.scheduler;

import org.reactivetechnologies.ticker.scheduler.DistributedScheduledTask.TaskContext;

/**
 * A distributed task instance which can be scheduled for run.
 * @author esutdal
 *
 */
public interface ScheduledTask {
	/**
	 * Cancel the current task.
	 * @return 
	 */
	boolean cancel();
	/**
	 * This is the method that has to be implemented in subclasses.
	 * @param context a context object that can have various runtime parameters.
	 */
	void run(TaskContext context);

	/**
	 * The CRON expression for the schedule.
	 * @return
	 */
	String cronExpression();
}
