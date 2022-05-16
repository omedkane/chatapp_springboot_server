package mr.gk2ms.chatapp.miscellaneous.utilities;

import java.util.ArrayList;
import java.util.List;

import mr.gk2ms.chatapp.miscellaneous.errors.ListOperationExceededException;

public class ListOperation<T> {
	private List<T> successfulOnes = new ArrayList<>();
	private List<T> failedOnes = new ArrayList<>();
	private int expectedCount;

	public ListOperation(int initialCount) {
		this.expectedCount = initialCount;
	}

	public void addSuccessful(T item) {
		if (isComplete())
			throw new ListOperationExceededException();

		successfulOnes.add(item);
	}

	public void addFailed(T item) {
		if (isComplete())
			throw new ListOperationExceededException();

		failedOnes.add(item);
	}

	public int getSuccessCount() {
		return successfulOnes.size();
	}

	public int getFailedCount() {
		return failedOnes.size();
	}

	public int getInitialCount() {
		return expectedCount;
	}

	public int getCurrentCount() {
		return getSuccessCount() + getFailedCount();
	}

	public boolean isComplete() {
		return expectedCount == getCurrentCount();
	}

	public boolean isSuccessful() {
		return expectedCount == getSuccessCount();
	}

	public List<T> getSuccessfulOnes() {
		return this.successfulOnes;
	}

	public void setSuccessfulOnes(List<T> successfulOnes) {
		this.successfulOnes = successfulOnes;
	}

	public List<T> getFailedOnes() {
		return this.failedOnes;
	}

	public void setFailedOnes(List<T> failedOnes) {
		this.failedOnes = failedOnes;
	}
}
