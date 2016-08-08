/*public class InterProcessLock implements java.io.Closeable
{
		private static final String MutexPrefix = "GD96B6_";
		private Mutex _mutex;

		public InterProcessLock(String path)
		{
			boolean newMutexCreated = false;
			String mutexName = MutexPrefix + path.replace('\\', '_');
			tangible.RefObject<Boolean> tempRef_newMutexCreated = new tangible.RefObject<Boolean>(newMutexCreated);
			_mutex = new Mutex(true, mutexName, tempRef_newMutexCreated);
			newMutexCreated = tempRef_newMutexCreated.argValue;
			if (!newMutexCreated)
			{
				_mutex.WaitOne();
			}
		}

		// Used to determine if Dispose() 
		// has already been called. 
		private boolean disposed = false;

		public final void close() throws java.io.IOException
		{
			// Call our helper method. 
			// Specifying "true" signifies that 
			// the object user triggered the cleanup. 
			CleanUp(true);

			// Now suppress finalization. 
			GC.SuppressFinalize(this);
		}

		private void CleanUp(boolean disposing)
		{
			// Be sure we have not already been disposed! 
			if (!this.disposed)
			{
				// If disposing equals true, dispose all 
				// managed resources. 
				if (disposing)
				{
					_mutex.ReleaseMutex();
				}

				if (_mutex != null)
				{
					_mutex.Close();
				}
				// Clean up unmanaged resources here. 
				disposed = true;
			}
		}

		protected void finalize() throws Throwable
		{
			// Call our helper method. 
			// Specifying "false" signifies that 
			// the GC triggered the cleanup. 
			CleanUp(false);
		}
}
*/