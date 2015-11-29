#include <stdio.h>

void *memcpy(void *dst, void const *src, size_t len) {
  long * plDst = (long *)dst;
  long const *plSrc = (long const *)src;
  while (len >= 4) {
    *plDst ++= *plSrc++;
    len -= 4;
  }

  char * pcDst = (char *) plDst;
  char const * pcSrc = (char const *) plSrc;

  while (len--) {
    *pcDst++ = *pcSrc++;
  }

  return (dst);
}

void main(char** args, int argv) {
  char str1[128] = {1,1,1,1,1,1,1};
  char str2[] = "ab\0cde";        /* 途中に空文字のある文字列 */
  int i;
  memcpy(str1, str2, 5);
  printf("コピー後中身の確認\n");
  for (i=0; i<7; i++)
    printf("%#x ",str1[i]);
  printf("\n");
}
