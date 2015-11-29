#include <stdio.h>

void *memcpy(void *dst, void const *src, size_t len) {
  long * plDst = (long *)dst;
  long const *plSrc = (long const *)src;
  if (!(src & 0xFFFFFFFC) && !(dst & 0xFFFFFFFC)) {
    while (len >= 4) {
      *plDst ++= *plSrc++;
      len -= 4;
    }
  }

  char * pcDst = (char *) plDst;
  char const * pcSrc = (char const *) plSrc;

  while (len--) {
    *pcDst++ = *pcSrc++;
  }

  return (dst);
}

void main(char** args, int argv) {

}