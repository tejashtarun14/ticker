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

import java.util.Date;
import java.util.TimeZone;

import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.support.CronTrigger;

public class DelegatingCronTrigger extends CronTrigger {

	private final TimeZone tzone;
	public DelegatingCronTrigger(String expression, TimeZone timeZone) {
		super(expression, timeZone);
		this.tzone = timeZone;
	}

	public Date getNextExecutionTime() {
		return nextExecutionTime;
	}

	private volatile Date nextExecutionTime, lastExecutionTime;
	@Override
	public Date nextExecutionTime(TriggerContext triggerContext) {
		nextExecutionTime = super.nextExecutionTime(triggerContext);
		return nextExecutionTime;
	}

	public Date getLastExecutionTime() {
		return lastExecutionTime;
	}

	public void setLastExecutionTime(Date lastExecutionTime) {
		this.lastExecutionTime = lastExecutionTime;
	}

	public TimeZone getTzone() {
		return tzone;
	}
}
