class MergeToIterator implements Iterator<Integer> {
	PriorityQueue<Number> q;
	List<List<Integer>> lists;

	public MergeToIterator(List<List<Integer>> input) {
		q = new PriorityQueue<>(input.size(), new Comparator<Number>(){
			@Override
			public int compare(Number n1, Number n2) {
				return n1.value - n2.value;
			}
		});

		lists = input;

		for (int i = 0; i < list.size(); i++) {
			if (lists.get(i).size() == 0) continue;
			q.add(new Number(lists.get(i).get(0), 0, i));
		}
	}

	@Override
	public boolean hasNext() {
		return !q.isEmpty();
	}

	@Override
	public int next() {
		Number num = q.poll();
		int index = num.index;
		int listIndex = num.listIndex;
		if (lists.get(listIndex).size() - 1 > index) {
			q.offer(new Number(lists.get(listIndex).get(index+1), index+1, listIndex));
		}

		return num.value;
	}
}


class Number {
	int value;
	int index;
	int listIndex;
	public Number(int v, int i, int l) {
		value = v;
		index = i;
		listIndex = l;
	}
}