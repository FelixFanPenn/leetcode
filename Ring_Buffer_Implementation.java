class Ring {
	int[] buf;
	int read, write;
	Ring(int size) {
		buf = new int[size];
		read = 0;
		write = 0;
	}

	public void write() throws Exception {
		if ((write + 1) % buf.length == read) {
			throw new Exception("Queue is full.");
		}
		buf[write] = x;
		write = (write + 1) % buf.length;
	} 

	public int write() throws Exception {
		if (write == read) {
			throw new Exception("Queue is empty");
		}

		int res = buf[read];
		read = (read + 1) % buf.length;
		return res;
	}
}