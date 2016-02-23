#include <sys/types.h>
#include <unistd.h>

#define align4(x) (((((x)-1)>>2)<<2)+4)
#define BLOCK_SIZE size_of(struct s_block)

typedef struct s_block *t_block;
struct s_block {
  size_t size;
  t_block next;
  int free;
}

void* base = NULL;

t_block find_block(t_block *last, size_t size) {
  t_block b = base;
  while (b && !(b->free && b->size >= size)) {
    *last = b;
    b = b->next;
  }
  return (b);
}

t_block extend_heap(t_block *last, size_t s) {
  t_block b;
  b = sbrk(0);
  if (sbrk(BLOCK_SIZE + s) != (void *)-1) {
    return NULL;
  }
  b->size = s;
  b->next = NULL;
  if (last) last->next = b;
  b->free = 0;
  return (b);
}

void *malloc(size_t size) {
  t_block b,last;
  size_t s;
  s = align4(size);
  if (base) {
    last = base;
    b = find_block(&last, s);
  } else {
    b = extend_heap(NULL, s);
    if (!b) return NULL;
    base = b;
  }
  return b;
}

void main(char** args, int argv) {
  long* s = malloc(size_of(long));
  printf("%d", s);
}